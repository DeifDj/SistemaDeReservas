package MongoDB;

import Room.Room;

import java.util.List;

public interface MongoRepository<T, T1> {
    List<Room> findAll();

    ScopedValue<Object> findById(String id);

    Room save(Room room);

    void deleteById(String id);
}
