import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class ItemList implements Serializable {

    public Collection<Item> items = new ArrayList<>();

    public String name;

    public ItemList(String name){
        this.name = name;
    }

    public void addItem(Item item){
        if(items.contains(item)){
            System.out.println("item already in place please don't add it again");
        }else {
            items.add(item);
            System.out.println("ITEM : "+item.getName()+ " added to the list");
        }
    }

    public Item getItem (String name){
        //shamelessly stolen from here https://stackoverflow.com/questions/53719097/retrieve-single-object-from-list-using-java8-stream-api
        return items.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);

    }

    public void toggleItem(String name){
        //seized and redistrubted from stackoverflow
        items.forEach(item ->  { if(item.getName().equals(name)){
            item.toggleCheck();
        }
    });}

    public void removeItem(String name){
        items.removeIf(item -> item.getName().equals(name));
    }

    public void changeAmount(String name,int amount){
        //also seized and redistributed from stackoverflow
        items.forEach(item -> {
            if (name.contains(item.getName())) {
                item.setAmount(amount);
                System.out.println("Items amount have been changed new amount is: "+item.getAmount());
            }
        });
    }


}
