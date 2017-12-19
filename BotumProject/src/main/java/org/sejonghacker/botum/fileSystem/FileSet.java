package org.sejonghacker.botum.fileSystem;

import java.util.ArrayList;

import com.oreilly.servlet.MultipartRequest;

public class FileSet {
	ArrayList<MultipartRequest> file;

	public FileSet(ArrayList<MultipartRequest> file) {
		super();
		this.file = file;
	}

	public FileSet() {
		super();
	}

	public ArrayList<MultipartRequest> getFile() {
		return file;
	}

	public void setFile(ArrayList<MultipartRequest> file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "FileSet [file=" + file + "]";
	}
	
}
