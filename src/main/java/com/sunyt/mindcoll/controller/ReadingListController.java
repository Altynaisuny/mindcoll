package com.sunyt.mindcoll.controller;

import com.sunyt.mindcoll.dao.ReadingListRepository;
import com.sunyt.mindcoll.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reading")
public class ReadingListController {
    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository){
        this.readingListRepository = readingListRepository;
    }

    public String readersBooks(@PathVariable("reader")String reader, @PathVariable("title")String title,  Model model){
        List<Book> books = readingListRepository.findAllByReaderAndAndTitle(reader, title);
        if (books != null){
            model.addAttribute("books", books);
        }
        return "readingList";
    }
}
