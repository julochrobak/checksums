checksums
=========

Simple utility to calculate single MD5 hash for multiple files.
Inspired by http://javarevisited.blogspot.ch/2013/06/how-to-generate-md5-checksum-for-files.html

1. compile

  ```
  > cd src
  > javac Checksums.java
  ```
  
2. run

  ```
  > # in the src directory
  > java Checksum PATH_TO_FILE_1 PATH_TO_FILE_2 ... PATH_TO_FILE_N
  ```
  
3. example
  
  ```
  > echo text1 > file1.txt
  > echo text2 > file2.txt
  > java Checksums file1.txt file2.txt
  364ab90c84e5b824ba3f7ebb760e0047
  ```
