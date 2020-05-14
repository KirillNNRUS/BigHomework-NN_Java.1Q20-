package ent.pks.controller;

import ent.pks.entity.Album;
import ent.pks.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/albums")
public class AlbumController {
    private IAlbumService iAlbumService;

    @Autowired
    public AlbumController(IAlbumService iAlbumService) {
        this.iAlbumService = iAlbumService;
    }

    @GetMapping("getAll")
    @ResponseBody
    List<Album> getAllAlbum() {
        return iAlbumService.getAll();
    }
}
