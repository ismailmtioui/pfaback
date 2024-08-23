package com._DSF.je.Service;
import com._DSF.je.Entity.Video;
import com._DSF.je.Repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com._DSF.je.Repository.CourseRepository;
import com._DSF.je.Entity.Course;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    private final Path rootLocation = Paths.get("uploaded-videos");

    public Video uploadVideo(MultipartFile file, String title, Long courseId) throws IOException {
        // Ensure the directory exists
        Files.createDirectories(rootLocation);

        // Store the file
        Path destinationFile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename()))
                .normalize().toAbsolutePath();
        file.transferTo(destinationFile);

        // Create and save the video entity
        Video video = new Video();
        video.setTitle(title);
        video.setFilePath(destinationFile.toString());
        video.setFileType(file.getContentType());
        video.setFileSize(file.getSize());
        video.setUploadDate(new Date());
        // Set the course entity (fetch from repository if needed)
        //video.setCourse(course);

        return videoRepository.save(video);
    }

    public Video getVideo(Long id) {
        return videoRepository.findById(id).orElse(null);
    }
}
