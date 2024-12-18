import java.util.*;
import java.util.stream.Collectors;

// Клас, що представляє навчальний заклад (згідно мого варіанту)
class EducationalInstitution {

    // Поля класу
    private String name;          // Назва навчального закладу
    private String address;       // Адреса
    private int studentsCount;    // Кількість студентів
    private int foundationYear;   // Рік заснування
    private String rectorName;    // Ім'я ректора


// Конструктор класу
    public EducationalInstitution(String name, String address, int studentsCount, int foundationYear, String rectorName) {
        this.name = name;
        this.address = address;
        this.studentsCount = studentsCount;
        this.foundationYear = foundationYear;
        this.rectorName = rectorName;
    }

    // Геттери для доступу до полів
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public String getRectorName() {
        return rectorName;
    }


// Перевизначення методу toString() для зручного виводу інформації про об'єкт.
    @Override
    public String toString() {
        return String.format("%s [Адреса: %s, Студенти: %d, Заснування: %d, Ректор: %s]",
                name, address, studentsCount, foundationYear, rectorName);
    }


// Перевизначення методу equals() для порівняння об'єктів.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EducationalInstitution that = (EducationalInstitution) obj;
        return studentsCount == that.studentsCount &&
                foundationYear == that.foundationYear &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(rectorName, that.rectorName);
    }


// Перевизначення методу hashCode().
    @Override
    public int hashCode() {
        return Objects.hash(name, address, studentsCount, foundationYear, rectorName);
    }
}

// Главний клас
public class Main {

    public static void main(String[] args) {
        // Створення масиву об'єктів
        List<EducationalInstitution> institutions = Arrays.asList(
                new EducationalInstitution("University A", "Address A", 5000, 1950, "Rector A"),
                new EducationalInstitution("University B", "Address B", 3000, 1970, "Rector B"),
                new EducationalInstitution("University C", "Address C", 4000, 1950, "Rector C"),
                new EducationalInstitution("University D", "Address D", 2000, 1980, "Rector D"),
                new EducationalInstitution("University E", "Address E", 3000, 1970, "Rector E"),
                new EducationalInstitution("University F", "Address F", 4500, 1960, "Rector F"),
                new EducationalInstitution("University G", "Address G", 3500, 1990, "Rector G"),
                new EducationalInstitution("University H", "Address H", 2800, 1965, "Rector H"),
                new EducationalInstitution("University I", "Address I", 7200, 1950, "Rector I"),
                new EducationalInstitution("University J", "Address J", 6000, 1940, "Rector J")
        );

        // Сортування за роком заснування (за зростанням), а за кількістю студентів (за спаданням)
        institutions = institutions.stream()
                .sorted(Comparator.comparingInt(EducationalInstitution::getFoundationYear)
                        .thenComparing(Comparator.comparingInt(EducationalInstitution::getStudentsCount).reversed()))
                .collect(Collectors.toList());

        // Виведення відсортованого масиву
        System.out.println("Відсортований список (за роком заснування (за зростанням), а за кількістю студентів (за спаданням)):");
        institutions.forEach(System.out::println);

        // Пошук заданого об'єкта
        EducationalInstitution target = new EducationalInstitution("University B", "Address B", 3000, 1970, "Rector B");
        boolean found = institutions.contains(target);

        System.out.println("\nРезультат пошуку об'єкта:");
        System.out.println(found ? "Об'єкт знайдено: " + target : "Об'єкт не знайдено");
    }
}