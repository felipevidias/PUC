import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Classe para armazenar uma lista de strings
class Lista {
    private String[] elementos;
    private int tamanho;

    // Construtor da classe Lista
    public Lista(int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    } // end Constructor

    // Método para adicionar um elemento à lista
    public void adicionar(String elemento) {
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
    } // end adicionar

    // Método para obter um elemento da lista pelo índice
    public String obter(int indice) {
        if (!(indice >= 0 && indice < this.tamanho)) {
            throw new IllegalArgumentException("Índice inválido");
        }
        return this.elementos[indice];
    } // end obter

    // Método para obter o tamanho atual da lista
    public int tamanho() {
        return this.tamanho;
    } // end tamanho
} // end Lista

// Classe para representar um personagem
class Personagem {
    private String id;
    private String name;
    private Lista alternativeNames;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private String hogwartsStaff;
    private String hogwartsStudent;
    private String actorName;
    private Lista alternativeActors;
    private String alive;
    private LocalDate dateOfBirth;
    private String yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private String wizard;

    // Construtor da classe Personagem
    public Personagem() {
        id = "";
        name = "";
        alternativeNames = new Lista(10);
        house = "";
        ancestry = "";
        species = "";
        patronus = "";
        hogwartsStaff = "";
        hogwartsStudent = "";
        actorName = "";
        alternativeActors = new Lista(10);
        alive = "";
        dateOfBirth = null;
        yearOfBirth = "";
        eyeColour = "";
        gender = "";
        hairColour = "";
        wizard = "";
    } // end Constructor

    // Métodos getters e setters para os atributos da classe Personagem
    public void setId(String s) {
        id = s;
    } // end setId

    public String getId() {
        return id;
    } // end getId

    public void setName(String s) {
        name = s;
    } // end setName

    public String getName() {
        return name;
    } // end getName

    public Lista getAlternativeNames() {
        return alternativeNames;
    } // end getAlternativeNames

    public void setHouse(String s) {
        house = s;
    } // end setHouse

    public String getHouse() {
        return house;
    } // end getHouse

    public void setAncestry(String s) {
        ancestry = s;
    } // end setAncestry

    public String getAncestry() {
        return ancestry;
    } // end getAncestry

    public void setSpecies(String s) {
        species = s;
    } // end setSpecies

    public String getSpecies() {
        return species;
    } // end getSpecies

    public void setPatronus(String s) {
        patronus = s;
    } // end setPatronus

    public String getPatronus() {
        return patronus;
    } // end getPatronus

    public void setHogwartsStaff(String x) {
        hogwartsStaff = x;
    } // end setHogwartsStaff

    public String isHogwartsStaff() {
        return hogwartsStaff;
    } // end isHogwartsStaff

    public void setHogwartsStudent(String x) {
        hogwartsStudent = x;
    } // end setHogwartsStudent

    public String isHogwartsStudent() {
        return hogwartsStudent;
    } // end isHogwartsStudent

    public void setActorName(String s) {
        actorName = s;
    } // end setActorName

    public String getActorName() {
        return actorName;
    } // end getActorName

    public Lista getAlternativeActors() {
        return alternativeActors;
    } // end getAlternativeActors

    public void setAlive(String x) {
        alive = x;
    } // end setAlive

    public String isAlive() {
        return alive;
    } // end isAlive

    public void setDateOfBirth(LocalDate date) {
        dateOfBirth = date;
    } // end setDateOfBirth

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    } // end getDateOfBirth

    public void setYearOfBirth(String data) {
        yearOfBirth = data;
    } // end setYearOfBirth

    public String getYearOfBirth() {
        return yearOfBirth;
    } // end getYearOfBirth

    public void setEyeColour(String s) {
        eyeColour = s;
    } // end setEyeColour

    public String getEyeColour() {
        return eyeColour;
    } // end getEyeColour

    public void setGender(String s) {
        gender = s;
    } // end setGender

    public String getGender() {
        return gender;
    } // end getGender

    public void setHairColour(String s) {
        hairColour = s;
    } // end setHairColour

    public String getHairColour() {
        return hairColour;
    } // end getHairColour

    public void setWizard(String s) {
        wizard = s;
    } // end setWizard

    public String isWizard() {
        return wizard;
    } // end isWizard

    // Método para ler os dados de uma linha e atribuir aos atributos da classe
    // Personagem
    public void ler(String line) {
        String[] data = line.split(";");

        setId(data[0]);
        setName(data[1]);

        String[] alternateNames = data[2].replace("[", "").replace("]", "").split(",");
        for (int i = 0; i < alternateNames.length; i++) {
            String name = alternateNames[i].trim(); // trim tira os espaços
            name = name.replaceAll("^'|'$", "");
            if (!name.isEmpty()) {
                alternativeNames.adicionar(name);
            }
        }
        // Atribuição dos dados dos personagens aos atributos correspondentes
        setHouse(data[3]);
        setAncestry(data[4]);
        setSpecies(data[5]);
        setPatronus(data[6]);
        setHogwartsStaff(data[7].equalsIgnoreCase("VERDADEIRO") ? "true" : "false");
        setHogwartsStudent(data[8].equalsIgnoreCase("VERDADEIRO") ? "true" : "false");
        setActorName(data[9]);
        setAlive(data[10].equalsIgnoreCase("VERDADEIRO") ? "true" : "false");

        String[] alternateActors = data[11].replace("[", "").replace("]", "").split(",");
        for (int i = 0; i < alternateActors.length; i++) {
            String actor = alternateActors[i].trim();
            actor = actor.replaceAll("^'|'$", "");
            if (!actor.isEmpty()) {
                alternativeActors.adicionar(actor);
            }
        }

        if (!data[12].isEmpty()) {
            var formatter = DateTimeFormatter.ofPattern("dd-M-yyyy");
            LocalDate date = LocalDate.parse(data[12].trim(), formatter);
            setDateOfBirth(date);
        }

        setYearOfBirth(data[13]);
        setEyeColour(data[14]);
        setGender(data[15]);
        setHairColour(data[16]);
        setWizard(data[17].equalsIgnoreCase("VERDADEIRO") ? "true" : "false");
    } // end ler

    // Metodo para imprimir os dados
    public void imprimir() {
        // Imprime os detalhes do personagem encontrado
        System.out.print("[" + getId() + " ## " + getName() + " ## " + "{");
        // Imprime os nomes alternativos
        if (getAlternativeNames().tamanho() > 0) {
            for (int i = 0; i < getAlternativeNames().tamanho() - 1; i++) {
                System.out.print(getAlternativeNames().obter(i) + ", ");
            } // end for
            System.out.print(getAlternativeNames().obter(getAlternativeNames().tamanho() - 1));
        } // end if
        System.out.print("}");
        // Imprime os detalhes restantes do personagem
        System.out.print(" ## " + getHouse() + " ## " + getAncestry() + " ## " + getSpecies() + " ## "
                + getPatronus() + " ## " + isHogwartsStaff() + " ## " + isHogwartsStudent() + " ## "
                + getActorName());

        System.out.print(" ## " + isAlive() + " ## "
                + (getDateOfBirth() != null
                        ? getDateOfBirth().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        : "N/A")
                + " ## " + getYearOfBirth() + " ## " + getEyeColour() + " ## " + getGender() + " ## "
                + getHairColour() + " ## " + isWizard());
        System.out.println("]");
    }
}

public class TP2Q07 {
    private static List<Personagem> personagens = new ArrayList<>();
    private static List<Personagem> sortByID = new ArrayList<>();

    // Método para ler os dados do arquivo "characters.csv" e criar objetos
    // Personagem correspondentes
    private static void readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("/tmp/characters.csv", Charset.forName("UTF-8")))) {
            String line;
            br.readLine(); // Lê e descarta a primeira linha (cabeçalho)
            while ((line = br.readLine()) != null) {
                Personagem p = new Personagem();
                p.ler(line);
                personagens.add(p);
            } // end while
        } catch (FileNotFoundException e) {
            System.out.println("NAO TEM ARQUIVO");
        } catch (IOException e) {
            System.out.println("LINHA NAO EXISTE");
        } // end try
    } // end readFromFile

    // Método para buscar um personagem pelo ID
    private static void searchByID(String id) {
        for (Personagem p : personagens) {
            if (p.getId().equals(id)) {
                p.imprimir();
                break;
            } // end if
        } // end for
    } // end searchByID

    // Metodo para criar uma lista de personagem pelo ID
    private static void addByID(String id) {
        for (Personagem p : personagens) {
            if (p.getId().equals(id)) {
                sortByID.add(p);
                break;
            } // end if
        } // end for
    } // end addByID

    private static void selectionSort() {
        for (int i = 0; i < sortByID.size() - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < sortByID.size(); j++) {
                if (sortByID.get(j).getName().compareTo(sortByID.get(menor).getName()) > 0) {
                    menor = j;
                } // end if
            } // end for
            if (menor != i) {
                Personagem tmp = sortByID.get(i);
                sortByID.set(i, sortByID.get(menor));
                sortByID.set(menor, tmp);
            } // end if
        } // end for

    } // end selectionSort

    public static void insertionSort2() {
        for (int i = 1; i < sortByID.size(); i++) {
            Personagem tmpPerson = sortByID.get(i);
            int j = i - 1;
            while ((j >= 0) && conditionInsertion2(sortByID.get(j), tmpPerson)) {
                sortByID.set(j + 1, sortByID.get(j));
                j--;
            }
            sortByID.set(j + 1, tmpPerson);
        }
    }

    private static boolean conditionInsertion(Personagem compare, Personagem current) {
        return compare.getDateOfBirth().isAfter(current.getDateOfBirth());
    }

    private static boolean conditionInsertion2(Personagem compare, Personagem current) {
        if (!compare.getDateOfBirth().isEqual(current.getDateOfBirth())) {
            return compare.getDateOfBirth().isAfter(current.getDateOfBirth());
        } else {
            return compare.getName().compareTo(current.getName()) > 0;
        }
    }

    public static void insertionSort() {
        for (int i = 1; i < sortByID.size(); i++) {
            Personagem tmpPerson = sortByID.get(i); // Obter o objeto da lista
            LocalDate tmpDate = tmpPerson.getDateOfBirth(); // Obter a data de nascimento do objeto

            int j = i - 1;
            while (j >= 0) {
                // Verificar se a data de aniversário é igual
                if (sortByID.get(j).getDateOfBirth().isEqual(tmpDate)) {
                    // Se a data de aniversário for igual, compare os nomes
                    if (sortByID.get(j).getName().compareTo(tmpPerson.getName()) > 0) {
                        sortByID.set(j + 1, sortByID.get(j));
                        j--;
                    } else {
                        break;
                    } // end if
                } else if (sortByID.get(j).getDateOfBirth().isAfter(tmpDate)) {
                    sortByID.set(j + 1, sortByID.get(j));
                    j--;
                } else {
                    break;
                } // end if
            } // end while
            sortByID.set(j + 1, tmpPerson);
        } // end for
    } // end insertionSort

    // Método principal do programa
    public static void main(String[] args) {
        readFromFile(); // Lê os dados do arquivo
        Scanner scanner = new Scanner(System.in);
        String line = "";

        while (!line.equalsIgnoreCase("FIM")) {
            line = scanner.nextLine().trim();
            addByID(line); // adiciona ID por linha
        } // end while

        // Ordena os personagens pelo ID usando o Insertion Sort
        insertionSort2();

        // Aqui você pode imprimir ou realizar qualquer outra operação com a lista
        // ordenada
        for (int i = 0; i < sortByID.size(); i++) {
            Personagem p = sortByID.get(i);
            p.imprimir(); // Imprimir apenas a data de aniversário
        }

        scanner.close();
    }
}
