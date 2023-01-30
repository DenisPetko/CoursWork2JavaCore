package Task;

public enum TypeOfTask {

    PERSONAL("Личная"), WORK("Рабочая");
    private final String typeOfTask;

    TypeOfTask(String typeOfTask) {
        if (typeOfTask == null || typeOfTask.isEmpty() || typeOfTask.isBlank()) {
            throw new IllegalArgumentException();
        } else {
            this.typeOfTask = typeOfTask;
        }
    }

    public String getTypeOfTask() {
        return typeOfTask;
    }

    @Override
    public String toString() {
        return "Тип задачи: " + typeOfTask;
    }
}

