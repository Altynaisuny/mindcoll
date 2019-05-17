package com.sunyt.mindcoll.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
    /**
     * read all by
     * @param reader
     * @param title
     * @return
     */
    List<Book> findAllByReaderAndAndTitle (String reader, String title);

}
