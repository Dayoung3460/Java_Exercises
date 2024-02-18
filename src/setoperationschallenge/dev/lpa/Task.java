package setoperationschallenge.dev.lpa;

enum Priority {HIGH, MEDIUM, LOW}

enum Status {IN_QUEUE, ASSIGNED, IN_PROGRESS}

public class Task implements Comparable<Task> {
    private String project;
    private String description;
    private String assignee;
    private Priority priority;
    private Status status;

    public Task(String project, String description, String assignee, Priority priority, Status status) {
        this.project = project;
        this.description = description;
        this.assignee = assignee;
        this.priority = priority;
        this.status = status;
    }

    public Task(String project, String description, String assignee, Priority priority) {
        this(project, description, assignee, priority,
                assignee == null ? Status.IN_QUEUE : Status.ASSIGNED);
    }

    public Task(String project, String description, Priority priority) {
        this(project, description, null, priority);
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString() {
        return "%-20s %-25s %-10s %-10s %s".formatted(project, description, priority,
                assignee, status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!project.equals(task.project)) return false;
        return description.equals(task.description);
    }

    @Override
    public int hashCode() {
        int result = project.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    // Comparable 인터페이스를 상속 했으므로 Comparable 내에 선언된 메소드(compareTo) 반드시 구현 해야함
    // compareTo(): 자기 자신과 매개 변수 객체 비교
    // 매개 변수보다 작으면 음수 반환, 같으면 0, 크면 양수 반환
    @Override
    public int compareTo(Task o) {
        int result = this.project.compareTo(o.toString());
        if (result == 0) {
            result = this.description.compareTo(o.description);
        }
        return result;
    }
}
