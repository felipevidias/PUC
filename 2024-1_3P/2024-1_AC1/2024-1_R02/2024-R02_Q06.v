module sequence_recognizer (
    input wire clk,
    input wire reset,
    input wire in,
    output reg out
);

    // Estado
    typedef enum reg [2:0] {
        IDLE,
        S0,
        S00,
        S1,
        S11
    } state_t;

    state_t current_state, next_state;

    // Combinação de lógica para a próxima transição de estado
    always @(*) begin
        next_state = current_state;
        out = 0;
        
        case (current_state)
            IDLE: begin
                if (in == 0) next_state = S0;
                else next_state = S1;
            end
            S0: begin
                if (in == 0) next_state = S00;
                else next_state = IDLE;
            end
            S00: begin
                if (in == 0) begin
                    next_state = IDLE;
                    out = 1; // Reconhecimento da sequência "000"
                end else next_state = IDLE;
            end
            S1: begin
                if (in == 1) next_state = S11;
                else next_state = IDLE;
            end
            S11: begin
                if (in == 1) begin
                    next_state = IDLE;
                    out = 1; // Reconhecimento da sequência "111"
                end else next_state = IDLE;
            end
            default: next_state = IDLE;
        endcase
    end

    // Registro da lógica de estado
    always @(posedge clk or posedge reset) begin
        if (reset)
            current_state <= IDLE;
        else
            current_state <= next_state;
    end

endmodule
