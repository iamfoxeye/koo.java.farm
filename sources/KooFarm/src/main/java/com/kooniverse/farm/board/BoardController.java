package com.kooniverse.farm.board;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletConfig;

@Controller
@RequestMapping("/board")
public class BoardController {

    final ServletConfig context;
    final BoardStorageManager storageManager;

    public BoardController(ServletConfig context, BoardStorageManager storageManager) {
        this.context = context;
        this.storageManager = storageManager;

        storageManager.setDocumentRootPath(context.getServletContext().getRealPath("/"));
    }

    @GetMapping("imageView/{imageName:.+}")
    public String imageView(Model model, @PathVariable String imageName) {
        String imagePath = storageManager.getImagePath(imageName);

        model.addAttribute("imageName", imageName);
        model.addAttribute("imagePath", imagePath);

        return "board/imageView.html";
    }

    @GetMapping("imageUpload")
    public String imageUpload(Model model) {
        return "board/imageUpload.html";
    }

    @PostMapping("imageUploadRequest")
    public String imageUploadRequest(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        String savedFile = storageManager.saveImage(file);
        if (savedFile != null && savedFile.length() > 0) {
            String nextPage = "redirect:/imageView/" + savedFile;
            return nextPage;

        } else {
            String nextPage = "redirect:/error/error";
            return nextPage;
        }
    }

    @GetMapping("iosImageUpload")
    public String iosImageUpload(Model model) {
        return "board/iosImageUpload.html";
    }

    @PostMapping("iosImageUploadRequest")
    @ResponseBody
    public Object iosImageUploadRequest(@RequestParam("file") MultipartFile file) {
        String savedFile = storageManager.saveImage(file);
        if (savedFile != null && savedFile.length() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();

            ObjectNode objectNode = objectMapper.createObjectNode();
            objectNode.put("url", "/board/imageView/" + savedFile);

            return objectNode;
        }

        return null;
    }
}
