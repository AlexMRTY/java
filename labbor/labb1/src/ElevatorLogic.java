/**
 * A representation of state and logic for an elevator.
 *
 * @author Anders Lindström, anderslm@kth.se
 */
public class ElevatorLogic {

    /**
     * Represents states for a floor: not selected, called for up, down or for a
     * specific destination.
     */
    public enum Choice {
        Not, Up, Down, To
    }

    private /*final*/ Choice[] floors; // index 0 represents the first floor
    private int currentFloor;
    private boolean directionUp;

    /**
     * Construct a new elevator object with the selected number of floors.
     *
     * @param noOfFloors the requested number of floors
     * @throws IllegalArgumentException if number of floors is less than 2
     */
    public ElevatorLogic(int noOfFloors) {
        // ...
    }

    /**
     * Construct a new elevator with 4 floors.
     */
    public ElevatorLogic() {
        // ...
    }

    /**
     * Return the number of floors.
     *
     * @return the number of floors
     */
    public int getSize() {
        // ...
        return 0;
    }

    /**
     * Returns the current floor for this elevator.
     *
     * @return the current floor
     */
    public int getCurrentFloor() {
        // ...
        return 0;
    }

    /**
     * Return whether this elevator is moving up (true) or down (false)
     *
     * @return true if direction is up
     */
    public boolean isDirectionUp() {
        // ...
        return false;
    }

    /**
     * Select a floor to move to (not necessary the next move). Corresponds to
     * a passenger selecting a floor inside the elevator.
     *
     * @param floor The selected floor
     */
    public void selectFloor(int floor) {
        // ...
    }

    /**
     * Call the elevator to a floor, indicating that the passenger wants to move
     * up.
     *
     * @param floor The floor the elevator is called to
     */
    public void callForUp(int floor) {
        // ...
    }

    /**
     * Call the elevator to a floor, indicating that the passenger then wants to move
     * down.
     *
     * @param floor The floor the elevator is called to
     */
    public void callForDown(int floor) {
        // ...
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
        // ...
        return false;
    }

    /**
     * Return a string representation of this elevators state.
     *
     * @return The string representation
     */
    @Override
    public String toString() {
        // ...
        return "";
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
                break;
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
        // ...
        return -1;
    }
}
