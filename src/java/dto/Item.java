    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package dto;

    /**
     *
     * @author Asus
     */
    public class Item {
        private int ItemId;
        private String ItemName;
        private int Price;
        private int typeID;
        private int statusID;
        private String Image;

        public Item(int ItemId, String ItemName, int Price, int typeID, int statusID, String Image) {
            this.ItemId = ItemId;
            this.ItemName = ItemName;
            this.Price = Price;
            this.typeID = typeID;
            this.statusID = statusID;
            this.Image = Image;
        }

        public Item() {       
        }

        public int getItemId() {
            return ItemId;
        }

        public void setItemId(int ItemId) {
            this.ItemId = ItemId;
        }

        public String getItemName() {
            return ItemName;
        }

        public void setItemName(String ItemName) {
            this.ItemName = ItemName;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public int getTypeID() {
            return typeID;
        }

        public void setTypeID(int typeID) {
            this.typeID = typeID;
        }

        public int getStatusID() {
            return statusID;
        }

        public void setStatusID(int statusID) {
            this.statusID = statusID;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }

        @Override
        public String toString() {
            return "Item{" + "ItemId=" + ItemId + ", ItemName=" + ItemName + ", Price=" + Price + ", typeID=" + typeID + ", statusID=" + statusID + ", Image=" + Image + '}';
        }


    }