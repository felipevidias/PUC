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
        S000,
        S1,
        S11,
        S111
    } state_t;

    state_t current_state, next_state;

    // Lógica combinacional para a próxima transição de estado
    always @(*) begin
        next_state = current_state;

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
                if (in == 0) next_state = S000;
                else next_state = IDLE;
            end
            S000: begin
                if (in == 0) next_state = S0;
                else next_state = S1;
            end
            S1: begin
                if (in == 1) next_state = S11;
                else next_state = IDLE;
            end
            S11: begin
                if (in == 1) next_state = S111;
                else next_state = IDLE;
            end
            S111: begin
                if (in == 1) next_state = S1;
                else next_state = S0;
            end
            default: next_state = IDLE;
        endcase
    end

    // Lógica sequencial para o registro do estado atual
    always @(posedge clk or posedge reset) begin
        if (reset)
            current_state <= IDLE;
        else
            current_state <= next_state;
    end

    // Lógica combinacional para a saída 'out'
    always @(*) begin
        case (current_state)
            S000: out = 1;
            S111: out = 1;
            default: out = 0;
        endcase
    end

endmodule
