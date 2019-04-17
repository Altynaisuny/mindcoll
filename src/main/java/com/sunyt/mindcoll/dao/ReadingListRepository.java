package com.sunyt.mindcoll.dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.sunyt.mindcoll.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingListRepository extends JpaRepository<Book, ID> {
    /**
     * read all by
     * @param reader
     * @param title
     * @return
     */
    List<Book> findAllByReaderAndAndTitle (String reader, String title);

}
