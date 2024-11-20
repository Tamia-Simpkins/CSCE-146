/*
 * Written by Tamia Simpkins
 */
public class OrderScheduler {
    private MinHeap<Order> Orders;
    private Order CurrentOrder;
    private int CurrentMinute;
    private int TotalOrder;
    private int SummedWaitingTimes;

    // Constructor to initialize the MinHeap
    public OrderScheduler() {
        Orders = new MinHeap<>();
        CurrentOrder = null;
        CurrentMinute = 0; 
        TotalOrder = 0;
        SummedWaitingTimes = 0;
    }

    // Accessor for current order
    public Order getCurrentOrder() {
        return CurrentOrder;
    }

    // Add order
    public void addOrder(Order order) {
        if (CurrentOrder == null) {
            CurrentOrder = order; 
        } else {
            Orders.add(order); //Add to the heap
        }
        TotalOrder++;
    }

    // Advance one minute
    public void advanceOneMinute() {
        CurrentMinute++;
        if (CurrentOrder != null) {
            CurrentOrder.cookForOneMinute();
            if (CurrentOrder.isDone()) {
                // Calculate waiting time for completed order
                int waitingTime = CurrentMinute - CurrentOrder.getArrivalTime();
                SummedWaitingTimes += waitingTime;
                // Get next order
                if (Orders.isEmpty()) {
                    CurrentOrder = null;
                } else {
                    CurrentOrder = Orders.remove();
                }
            }
        }
    }

    public boolean isDone() {
        return CurrentOrder == null; 
    }

    public double getAverageWaitingTime() {
        if (TotalOrder == 0) {
            return 0;
        } else {
            return (double) SummedWaitingTimes / TotalOrder; // Calculate average waiting time
        }
    }
}
