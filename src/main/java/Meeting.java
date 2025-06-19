public class Meeting extends Task{

    protected String topic;
    protected String project;
    protected String start;

    public Meeting(int id, String project, String topic, String start) {
        super(id);
        this.project = project;
        this.topic = topic;
        this.start = start;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    @Override
    public boolean matches(String query) {
        if (topic.toLowerCase().contains(query.toLowerCase())) {
            return true;
        }
        if (project.toLowerCase().contains(query.toLowerCase())) {
            return true;
        }
        return false;
    }
}
