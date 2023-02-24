package gb.ru.pet_registry.data;

public class Counter implements AutoCloseable{
    int counter = 0;

    public void add() throws Exception {
        counter++;
        System.out.println("У Вас " + counter + " животных.");
    }

    @Override
    public void close() throws Exception {

    }
}
