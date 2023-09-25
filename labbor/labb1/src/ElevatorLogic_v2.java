import static java.util.stream.IntStream.range;

/**
 * A representation of state and logic for an elevator.
 *
 * @author Anders Lindström, anderslm@kth.se
 */
public class ElevatorLogic_v2 {

    /**
     * Represents states for a floor: not selected, called for up, down or for a
     * specific destination.
     */
    public enum Choice {
        Not, Up, Down, To
    }
    private static final int DEFAULT_NUM_OF_FLOORS = 4;

    private final Choice[] floors; // index 0 represents the first floor
    private int currentFloor;
    private boolean directionUp;

    /**
     * Construct a new elevator object with the selected number of floors.
     *
     * @param nrOfFloors the requested number of floors
     * @throws IllegalArgumentException if number of floors is less than 2
     */
    public ElevatorLogic_v2(int nrOfFloors) {
        if (nrOfFloors < 2) throw new IllegalArgumentException("noOfFloors too low: " + nrOfFloors);
        floors = new Choice[nrOfFloors];
        range(0, floors.length).forEach(i -> floors[i] = Choice.Not);
        currentFloor = 0;
        directionUp = true;
    }

    /**
     * Construct a new elevator with 4 floors.
     */
    public ElevatorLogic_v2() {
        floors = new Choice[DEFAULT_NUM_OF_FLOORS];
        range(0, floors.length).forEach(i -> floors[i] = Choice.Not);
        currentFloor = 0;
        directionUp = true;
    }

    /**
     * Return the number of floors.
     *
     * @return the number of floors
     */
    public int getSize() {
        return floors.length;
    }

    /**
     * Returns the current floor for this elevator.
     *
     * @return the current floor
     */
    public int getCurrentFloor() {
        return currentFloor;
    }

    /**
     * Return whether this elevator is moving up (true) or down (false)
     *
     * @return true if direction is up
     */
    public boolean isDirectionUp() {
        return this.directionUp;
    }

    /**
     * Select a floor to move to (not necessary the next move). Corresponds to
     * a passenger selecting a floor inside the elevator.
     *
     * @param floor The selected floor
     */
    public void selectFloor(int floor) {
        this.floors[floor] = Choice.To;
    }

    /**
     * Call the elevator to a floor, indicating that the passenger wants to move
     * up.
     *
     * @param floor The floor the elevator is called to
     */
    public void callForUp(int floor) {
        this.floors[floor] = floors[floor] == Choice.Down ? Choice.To : Choice.Up;
    }

    /**
     * Call the elevator to a floor, indicating that the passenger then wants to move
     * down.
     *
     * @param floor The floor the elevator is called to
     */
    public void callForDown(int floor) {
        this.floors[floor] = floors[floor] == Choice.Up ? Choice.To : Choice.Down;
    }

    /**
     * Move the next floor selected. If the current direction is up the
     * elevator moves to the next floor selected (Up or To) upwards, or if none
     * selected upwards, the next floor selected in the downward direction (Down
     * or To). If the current direction is down the corresponding is done in the
     * downward direction.
     *
     * @return true if the elevator moves, false if not (no floor was selected)
     */
    public boolean moveToNextFloor() {
        int next = -1;
        if (directionUp) {
            next = searchUp();
            if (next == -1) {
                next = searchDown();
                if (next != -1) {
                    this.directionUp = false;
                }
            }
        } else {
            next = searchDown();
            if (next == -1) {
                next = searchUp();
                if (next != -1) {
                    this.directionUp = true;
                }
            }
        }

        if (next != -1) {
            if (directionUp) {
                this.currentFloor += 1;
                if (floors[currentFloor] == Choice.Up || floors[currentFloor] == Choice.To || currentFloor == floors.length -1 ) this.floors[currentFloor] = Choice.Not;
            } else {
                this.currentFloor -= 1;
                if (floors[currentFloor] == Choice.Down || floors[currentFloor] == Choice.To || currentFloor == 0 ) this.floors[currentFloor] = Choice.Not;
            }
            return true;
        }
        return false;
    }

    /**
     * Return a string representation of this elevators state.
     *
     * @return The string representation
     */
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("[ ");
        for (Choice floor : floors ) info.append(floor).append(" ");
        info.append("] ").append(", Up = ").append(directionUp).append("\n");


        return info.toString();
    }

    // returns the first selected floor upwards, or -1
    // NB! Choice. Down is ignored upwards, unless no other
    // alternative is selected, in which case the highest
    // value is returned.
    private int searchUp() {
        int next = -1;
        // check for To or Up
        for (int i = currentFloor + 1; i < floors.length; i++) {
            if (floors[i] == Choice.Up || floors[i] == Choice.To) {
                next = i;
                break; // Why are not returning directly to break out of the function.
            }
        }
        // if neither Up nor To, check for highest Down
        if (next == -1) {
            for (int i = floors.length - 1; i > currentFloor; i--) {
                if (floors[i] == Choice.Down) {
                    next = i;
                    break;
                }
            }
        }
        return next;
    }

    // returns the first selected floor downwards, or -1
    // NB! Choice. Up is ignored downwards, unless no other
    // alternative is selected, in which case the lowest 
    // value is returned.
    private int searchDown() {
        int next = -1;
        // Check for Down or To
        for (int i = currentFloor - 1; i >= 0; i--) {
            if (floors[i] == Choice.Down|| floors[i] == Choice.To) {
                next = i;
                return next;
            }
        }

        // if neither Down nor To, check for Up
        for (int i = 0 ; i < currentFloor; i++) {
            if (floors[i] == Choice.Up) {
                next = i;
                return next;
            }
        }
        return next;
    }
}
