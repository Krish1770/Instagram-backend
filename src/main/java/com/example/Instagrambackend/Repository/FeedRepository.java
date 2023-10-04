package com.example.Instagrambackend.Repository;

import com.example.Instagrambackend.Model.Feed;
import com.example.Instagrambackend.Model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedRepository extends JpaRepository<Feed,Long> {

   List<Feed> findAllByUserIdUserIdAndIsArchived(Long userId,Boolean isArchived);

   List<Feed> findAllByPrivacyTypeAndIsArchivedAndAndUserIdAccountTypeOrderByUploadDate(String privacyType,boolean isArchived,String AccountType);
}
