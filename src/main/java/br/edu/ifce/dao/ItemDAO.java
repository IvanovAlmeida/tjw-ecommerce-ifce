package br.edu.ifce.dao;

import br.edu.ifce.model.Item;
import br.edu.ifce.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ItemDAO {
    public Item FindItem(int id) {
        EntityManager manager = JPAUtil.getEntityManager();
        Item item = manager.find(Item.class, id);
        manager.close();
        return item;
    }

    public List<Item> ListAll() {
        EntityManager manager = JPAUtil.getEntityManager();
        TypedQuery<Item> query = manager.createQuery("SELECT it FROM Item it", Item.class);

        List<Item> items = query.getResultList();
        manager.close();

        return items;
    }

    public void Insert(Item item) {
        EntityManager manager = JPAUtil.getEntityManager();

        manager.getTransaction().begin();
        Item i = new Item();

        i.setName(item.getName());
        i.setDescription(item.getDescription());
        i.setImage(item.getImage());
        i.setPrice(item.getPrice());

        manager.persist(i);
        manager.getTransaction().commit();
        manager.close();
    }

    public void Update(Item item) {
        EntityManager manager = JPAUtil.getEntityManager();
                Item i = manager.find(Item.class, item.getId());

        manager.getTransaction().begin();

        i.setName(item.getName());
        i.setDescription(item.getDescription());
        i.setImage(item.getImage());
        i.setPrice(item.getPrice());

        manager.persist(i);
        manager.getTransaction().commit();
        manager.close();
    }

    public void Delete(int id) {
        EntityManager manager = JPAUtil.getEntityManager();
        Item i = manager.find(Item.class, id);

        manager.getTransaction().begin();

        manager.remove(i);

        manager.getTransaction().commit();
        manager.close();
    }
}
