package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog = blogRepository2.findById(blogId).get();
        Image image = new Image(dimensions,description,blog);
        imageRepository2.save(image);
        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        int count=0;
        String[] dimarr=screenDimensions.split("X");
        Image image=imageRepository2.findById(id).get();
        String dimensionOfImage=image.getDimensions();
        String[] imgarr=dimensionOfImage.split("X");
        int imgx=Integer.parseInt(imgarr[0]);
        int imgy=Integer.parseInt(imgarr[1]);

        int dimx=Integer.parseInt(dimarr[0]);
        int dimy=Integer.parseInt(dimarr[1]);

        //4X4 = 4/2*4/2 = 4 images
        int countx=dimx/imgx;
        int county=dimy/imgy;
        count=countx*county;

        return count;
    }
}
