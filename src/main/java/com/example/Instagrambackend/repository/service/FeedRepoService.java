package com.example.Instagrambackend.repository.service;

import com.example.Instagrambackend.model.Feed;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FeedRepoService {
    List<Feed> findAllByUserIdUserIdAndIsArchived(Long userId, Boolean isArchived);

    List<Feed> findAllByPrivacyTypeAndIsArchivedAndAndUserIdAccountTypeOrderByUploadDate(String privacyType,boolean isArchived,String AccountType);

    Feed save(Feed feed);

    Optional<Feed> findById(Long feedId);


}
