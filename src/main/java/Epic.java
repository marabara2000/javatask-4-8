public class Epic extends Task {


    private String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    @Override
    public boolean matches(String query) {
        //String[] subtasks = new String[];
        for (String subtask : subtasks) {
            if (subtask.contains(query)) {
                return true;
            }
        }
        return false;
    }


    public String[] getSubtasks() {
        return subtasks;
    }

}
