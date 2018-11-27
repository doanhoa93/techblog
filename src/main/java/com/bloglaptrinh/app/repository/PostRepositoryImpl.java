package com.bloglaptrinh.app.repository;

import com.bloglaptrinh.app.domain.Post;
import com.bloglaptrinh.app.model.PostSearchRequest;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void lock(long id) {
        /*CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<Post> root = query.from(Post.class);
        query.select(root.get(Post_.id));
        query.where(cb.equal(root.get(Post_.id), id));
        entityManager.createQuery(query).setLockMode(LockModeType.PESSIMISTIC_WRITE).getSingleResult();*/
    }

    @Override
    public Page<Post> search(PostSearchRequest request, Pageable pageable) {

        int resultSize = 0;

        @SuppressWarnings("unchecked")
        List<Post> results = new ArrayList<>();
        results.add(new Post());
        return new PageImpl<>(results, pageable, resultSize);
    }
}
