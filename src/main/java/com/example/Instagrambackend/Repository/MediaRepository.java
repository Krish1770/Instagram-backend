package com.example.Instagrambackend.Repository;

import com.example.Instagrambackend.Model.Feed;
import com.example.Instagrambackend.Model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends JpaRepository<Media,Long>
{
}
