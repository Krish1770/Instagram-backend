package com.example.Instagrambackend.Repository;

import com.example.Instagrambackend.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>
{
}
