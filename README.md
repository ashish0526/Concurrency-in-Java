# Concurrency-in-Java

Each hydrogen thread waits to be grouped with one other hydrogen and oxygen before returning
Each oxygen thread waits for two other hydrogens before returning
Only one thread access shared state at a time
There is only one condition any thread will wait for, i.e. a water molecule being formed. However, it will be necessary to signal hydrogen and oxygen threads independently, so  we will use two condition variables, waitingH and waitingO.
It will be necessary to know the number of hydrogen and oxygen threads in the monitor.   But it would be more useful to know how many hydrogen and oxygen threads have been assigned and have not been assigned to water molecules; let these be int wH (number of waiting hydrogens), wO (number of waiting oxygens), aH (number of assigned hydrogens), and aO (number of assigned oxygens). These are all initialized to 0.
