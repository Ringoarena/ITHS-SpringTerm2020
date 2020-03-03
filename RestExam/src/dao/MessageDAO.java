package dao;

import model.Message;

import java.util.List;

public interface MessageDAO {
    void create(Message message);
    List<Message> getAll(Long lastId);
}
