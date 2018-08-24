package com.fredy.projectbackend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
/*
* this is file is to display images from the server applications end point.
* */

@RestController
public class FileContollers {
    @RequestMapping(value ="/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] getImage(@PathVariable String id, HttpServletResponse response) throws IOException{

        File serverFile = new File("src/main/image/"+ id + ".png");
        return Files.readAllBytes(serverFile.toPath());




    }

}
