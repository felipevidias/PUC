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
    }

    // Método para adicionar um elemento à lista
    public void adicionar(String elemento) {
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
    }

    // Método para obter um elemento da lista pelo índice
    public String obter(int indice) {
        if (!(indice >= 0 && indice < this.tamanho)) {
            throw new IllegalArgumentException("Índice inválido");
        }
        return this.elementos[indice];
    }

    // Método para obter o tamanho atual da lista
    public int tamanho() {
        return this.tamanho;
    }
}

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
    }

    // Métodos getters e setters para os atributos da classe Personagem
    public void setId(String s) {
        id = s;
    }

    public String getId() {
        return id;
    }

    public void setName(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }

    public Lista getAlternativeNames() {
        return alternativeNames;
    }

    public void setHouse(String s) {
        house = s;
    }

    public String getHouse() {
        return house;
    }

    public void setAncestry(String s) {
        ancestry = s;
    }

    public String getAncestry() {
        return ancestry;
    }

    public void setSpecies(String s) {
        species = s;
    }

    public String getSpecies() {
        return species;
    }

    public void setPatronus(String s) {
        patronus = s;
    }

    public String getPatronus() {
        return patronus;
    }

    public void setHogwartsStaff(String x) {
        hogwartsStaff = x;
    }

    public String isHogwartsStaff() {
        return hogwartsStaff;
    }

    public void setHogwartsStudent(String x) {
        hogwartsStudent = x;
    }

    public String isHogwartsStudent() {
        return hogwartsStudent;
    }

    public void setActorName(String s) {
        actorName = s;
    }

    public String getActorName() {
        return actorName;
    }

    public Lista getAlternativeActors() {
        return alternativeActors;
    }

    public void setAlive(String x) {
        alive = x;
    }

    public String isAlive() {
        return alive;
    }

    public void setDateOfBirth(LocalDate date) {
        dateOfBirth = date;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setYearOfBirth(String data) {
        yearOfBirth = data;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setEyeColour(String s) {
        eyeColour = s;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public void setGender(String s) {
        gender = s;
    }

    public String getGender() {
        return gender;
    }

    public void setHairColour(String s) {
        hairColour = s;
    }

    public String getHairColour() {
        return hairColour;
    }

    public void setWizard(String s) {
        wizard = s;
    }

    public String isWizard() {
        return wizard;
    }

    // Método para ler os dados de uma linha e atribuir aos atributos da classe
    // Personagem
    public void ler(String line) {
        String[] data = line.split(";");

        setId(data[0]);
        setName(data[1]);

        String[] alternateNames = data[2].replace("[", "").replace("]", "").split(",");
        for (int i = 0; i < alternateNames.length; i++) {
            String name = alternateNames[i].trim();
            name = name.replaceAll("^'|'$", "");
            if (!name.isEmpty()) {
                alternativeNames.adicionar(name);
            }
        }

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
    }

    // Método para imprimir os dados
    public void imprimir() {
        System.out.print("[" + getId() + " ## " + getName() + " ## " + "{");

        if (getAlternativeNames().tamanho() > 0) {
            for (int i = 0; i < getAlternativeNames().tamanho() - 1; i++) {
                System.out.print(getAlternativeNames().obter(i) + ", ");
            }
            System.out.print(getAlternativeNames().obter(getAlternativeNames().tamanho() - 1));
        }
        System.out.print("}");

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

public class TP2Q09 {
    private static List<Personagem> personagens = new ArrayList<>();
    private static List<Personagem> sortByID = new ArrayList<>();

    private static void readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("/tmp/characters.csv", Charset.forName("UTF-8")))) {
            String line;
            br.readLine(); // Lê e descarta a primeira linha (cabeçalho)
            while ((line = br.readLine()) != null) {
                Personagem p = new Personagem();
                p.ler(line);
                personagens.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println("NAO TEM ARQUIVO");
        } catch (IOException e) {
            System.out.println("LINHA NAO EXISTE");
        }
    }

    private static void searchByID(String id) {
        for (Personagem p : personagens) {
            if (p.getId().equals(id)) {
                p.imprimir();
                break;
            }
        }
    }

    private static void addByID(String id) {
        for (Personagem p : personagens) {
            if (p.getId().equals(id)) {
                sortByID.add(p);
                break;
            }
        }
    }

    private static void swap(int i, int j) {
        if (i <= sortByID.size() && j <= sortByID.size()) {
            Personagem tmp = sortByID.get(i - 1);
            sortByID.set(i - 1, sortByID.get(j - 1));
            sortByID.set(j - 1, tmp);
        }
    }

    private static void selectionSort() {
        for (int i = 0; i < sortByID.size() - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < sortByID.size(); j++) {
                if (sortByID.get(j).getName().compareTo(sortByID.get(menor).getName()) > 0) {
                    menor = j;
                }
            }
            if (menor != i) {
                swap(i + 1, menor + 1);
            }
        }
    }

    public static void insertionSort() {
        for (int i = 1; i < sortByID.size(); i++) {
            Personagem tmpPerson = sortByID.get(i);
            LocalDate tmpDate = tmpPerson.getDateOfBirth();

            int j = i - 1;
            while (j >= 0) {
                if (sortByID.get(j).getDateOfBirth().isEqual(tmpDate)) {
                    if (sortByID.get(j).getName().compareTo(tmpPerson.getName()) > 0) {
                        sortByID.set(j + 1, sortByID.get(j));
                        j--;
                    } else {
                        break;
                    }
                } else if (sortByID.get(j).getDateOfBirth().compareTo(tmpDate) > 0) {
                    sortByID.set(j + 1, sortByID.get(j));
                    j--;
                } else {
                    break;
                }
            }
            sortByID.set(j + 1, tmpPerson);
        }
    }

    private static boolean hasFilho(int i, int tam) {
        return (i * 2 <= tam);
    }

    private static int getMaiorFilho(int i, int tam) {
        int filho;
        if ((2 * i == tam) || (sortByID.get(2 * i - 1).getHairColour().compareTo(sortByID.get(2 * i).getHairColour()) > 0)) {
            filho = 2 * i;
        } else {
            filho = 2 * i + 1;
        }
        return filho;
    }

    private static void construir(int tam) {
        for (int i = tam / 2; i >= 1; i--) {
            reconstruir(i, tam);
        }
    }

    private static void reconstruir(int i, int tam) {
        while (hasFilho(i, tam)) {
            int filho = getMaiorFilho(i, tam);
            if (sortByID.get(i - 1).getHairColour().compareTo(sortByID.get(filho - 1).getHairColour()) < 0) {
                swap(i, filho);
                i = filho;
            } else {
                break;
            }
        }
    }

    private static void heapSort() {
        // Construir o heap
        for (int tam = 2; tam <= sortByID.size(); tam++) {
            construir(tam);
        }
    
        // Ordenação propriamente dita
        int tam = sortByID.size();
        while (tam > 1) {
            swap(1, tam);
            tam--;
            reconstruir(1, tam);
        }
    
        // Verificar se há personagens com a mesma cor de cabelo e ordená-los pelo nome
        for (int i = 1; i < sortByID.size(); i++) {
            int j = i - 1;
            while (j >= 0 && sortByID.get(j).getHairColour().equals(sortByID.get(j + 1).getHairColour())) {
                if (sortByID.get(j).getName().compareTo(sortByID.get(j + 1).getName()) > 0) {
                    swap(j + 1, j + 2);
                    j--;
                } else {
                    break;
                }
            }
        }
    }
    

    public static void main(String[] args) {
        readFromFile(); // Lê os dados do arquivo
        Scanner scanner = new Scanner(System.in);
        String line = "";

        while (!line.equalsIgnoreCase("FIM")) {
            line = scanner.nextLine().trim();
            addByID(line); // adiciona ID por linha
        }

        heapSort();

        for (Personagem p : sortByID) {
            p.imprimir(); // Imprimir todos os personagens ordenados
        }

        scanner.close();
    }
}
