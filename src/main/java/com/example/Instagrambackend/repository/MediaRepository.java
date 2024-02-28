package com.example.Instagrambackend.repository;

import com.example.Instagrambackend.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends JpaRepository<Media,Long>
{
}
