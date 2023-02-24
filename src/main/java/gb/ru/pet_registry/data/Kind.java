package gb.ru.pet_registry.data;

public enum Kind {

    AVERAGE("Средний"),
    CRICETUS("Обыкновенный"),
    GREY("Серый");

    private final String title;

    Kind(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " хомяк";
    }

}
