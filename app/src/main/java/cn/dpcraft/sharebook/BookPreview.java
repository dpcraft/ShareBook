package cn.dpcraft.sharebook;

/**
 * Created by DPC on 2016/12/8.
 */
public class BookPreview {
    private int imageId;
    private String name;
    private String author;
    private String publishingHouse;
    private String price;

    public BookPreview(){
        this.imageId = R.drawable.ic_belonged;
        this.name = "从你的全世界路过";
        this.author = "张嘉佳";
        this.publishingHouse = "湖南文艺出版社";
        this.price = "9.99";
    }
    public BookPreview(int imageId,String name,String author,String publishingHouse,String price){
        this.imageId = imageId;
        this.name = name;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.price = price;
    }
    public int getImageid(){
        return imageId;
    }
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public String getPublishingHouse(){
        return publishingHouse;
    }
    public String getPrice(){
        return price;
    }
}
