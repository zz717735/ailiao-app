package com.chongdong.ailiaoapp.factory;


import com.chongdong.ailiaoapp.model.AlbumPicture;
import com.chongdong.ailiaoapp.model.Relationship;

public class EntityFactory {
    public static AlbumPicture createAlbumPicture(){
        return new AlbumPicture();
    }

    public static Relationship createRelationship(){return new Relationship();}
}
