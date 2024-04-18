package dealing.with.generalization;

public class TheaterPiece extends Event {
  private final String description;
  private final int numberOfActors;
  private boolean running;
  private long startTime = 0;
  private long stopTime = 0;

  public TheaterPiece(String description, int numberOfActors) {
    this.description = description;
    this.numberOfActors = numberOfActors;
  }

  public void start() {
    if (running) {
      throw new IllegalStateException("Concert is already in progress");
    }
    this.startTime = System.currentTimeMillis();
    running = true;
  }

  public void end() {
    if (running) {
      running = false;
      stopTime = System.currentTimeMillis();
    }
  }

  public long calculateElapsedTimes() {
    return running ? (System.currentTimeMillis() - startTime) : (stopTime - startTime);
  }
}