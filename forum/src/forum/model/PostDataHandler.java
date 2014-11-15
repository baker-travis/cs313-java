package forum.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PostDataHandler {
	
	private String filename;

	public PostDataHandler(String filename) {
		super();
		this.filename = filename;
	}
	
	public boolean addPost(Post thePost) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
			writer.write(thePost.toFileString() + "\n");
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public List<Post> getPosts() {
		List<Post> list = new ArrayList<Post>();

        try {
             BufferedReader reader = new BufferedReader(new FileReader(filename));

             String line;

             while ((line = reader.readLine()) != null) {
                  Post post = new Post();
                  post.loadFromFileString(line);
                  list.add(post);
             }
             
             Collections.reverse(list);
             
             reader.close();

        } catch (IOException e) {
             e.printStackTrace();
        }

        return list;
	}
}
