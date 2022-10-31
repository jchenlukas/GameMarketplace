package com.example.CommunityMarket.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table (name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    @JsonProperty("transaction_id")
    private Integer transactionID;
    @Column(name = "seller_id")
    @JsonProperty("seller_id")
    private String sellerID;
    @Column(name = "buyer_id")
    @JsonProperty("buyer_id")
    private String buyerID;
    @Column(name = "item_id")
    @JsonProperty("item_id")
    private Integer itemID;
    @Column(name = "price")
    @JsonProperty("price")
    private int price;
    @Column(name = "post_time")
    @JsonProperty("post_time")
    private LocalDateTime postTime;
    @Column(name = "quantity")
    @JsonProperty("quantity")
    private int quantity;
    @Column(name = "is_open")
    @JsonProperty("isOpen")
    private boolean isOpen;
    @Column(name = "close_time")
    @JsonProperty("close_time")
    private LocalDateTime closeTime;


    public Transaction(Integer transactionID, String sellerID, String buyerID, Integer itemID, Integer price, Integer quantity) {
        this.transactionID = transactionID;
        this.sellerID = sellerID;
        this.buyerID = buyerID;
        this.itemID = itemID;
        this.price = price;
        this.quantity = quantity;

    }

    public Transaction() {
    }

    public Integer getTransactionID() {
        return transactionID;
    }

    public String getSellerID() {
        return sellerID;
    }

    public String getBuyerID() {
        return buyerID;
    }

    public Integer getItemID() {
        return itemID;
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }

    public void setBuyerID(String buyerID) {
        this.buyerID = buyerID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID='" + transactionID + '\'' +
                ", sellerID='" + sellerID + '\'' +
                ", buyerID='" + buyerID + '\'' +
                ", itemID='" + itemID + '\'' +
                ", price=" + price +
                ", postTime=" + postTime +
                ", quantity=" + quantity +
                ", isOpen=" + isOpen +
                ", closeTime=" + closeTime +
                '}';
    }
}
