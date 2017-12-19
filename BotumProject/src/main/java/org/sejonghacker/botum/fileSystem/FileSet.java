package org.sejonghacker.botum.fileSystem;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartRequest;

public class FileSet {
	ArrayList<MultipartRequest> files;
	MultipartRequest file;

	public FileSet(ArrayList<MultipartRequest> files, MultipartRequest file) {
		super();
		this.files = files;
		this.file = file;
	}

	public ArrayList<MultipartRequest> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<MultipartRequest> files) {
		this.files = files;
	}

	public void setFile(MultipartRequest file) {
		this.file = file;
	}

	public FileSet(ArrayList<MultipartRequest> files) {
		super();
		this.files = files;
	}

	public FileSet() {
		super();
	}

	public ArrayList<MultipartRequest> getFile() {
		return files;
	}

	public void setFile(ArrayList<MultipartRequest> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "FileSet [files=" + files + ", file=" + file + "]";
	}

}
