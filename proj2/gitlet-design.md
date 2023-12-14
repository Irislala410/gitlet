# Gitlet Design Document

**Name**: Ruo Liang

## Classes and Data Structures

### Main

#### Static Methods

1. void validateNumArgs(String[] args, int num) : If a user inputs a command with the wrong number or format of operands, print the message Incorrect operands. and exit.

### Repository

#### Instance Variables

1. final File CWD : The current working directory.
2. final File GITLET_DIR : The .gitlet directory.
3. final File STAGING
4. final File RMSTAGING
5. final File BLOB
6. final File COMMIT
7. final File HEAD_DIR
8. final File MASTER_DIR
9. final File HEAD
10. final File MASTER

#### Static Methods

1. void checkInitial() : Check if a user inputs a command that requires being in an initialized Gitlet working directory (i.e., one containing a .gitlet subdirectory), but is not in such a directory. If so, print the message "Not in an initialized Gitlet directory." and exit.
2. void setupPersistence() : For the initialization of the working directory: create .gitlet and in it, create .staging, .rmstaging, .blob, .commit for storing different files. Create the initial commit.
3. void add(String addFile) : stage file.
4. public static boolean fileInCurrentCommit(String fileName) : Return if the file is in current commit.
5. public static void removeFromRMSTAGING(String fileToRm) : Remove the file from RMSTAGING directory if it is there.
6. public static boolean sameContentInCurrentCommit(String fileName) : Return if the file is the same with its version in current commit.
7. public static boolean fileInStagingArea(String fileName) ： Return if the file is in staging area.
8. 


### Commit

#### Instance Variables

1. String message: the message of this commit.
2. String parent: the parent of this commit.
3. String timestamp:
4. String parent:
5. HashMap<String, String> filenameBlob: contains the file names and their blobs in the commit.
6. 

#### Instance Method

1. public Commit(String message, String parent, String timestamp) : the constructor of commit object. message: the commit message provided by the user. parent: the parent commit sha1 of this commit. timestamp: the current local time when commit is constructed. 
2. public void saveCommit(File saveCommitDIR) : write commit into a file whose name is the sha1 of the commit. file is plain file.
3. public static void updateMaster(String commitSha1) : update the Master commit.
4. public static void updateHEAD(String commitSha1) : update the HEAD commit.
5. public boolean containFile(String fileName) : Return if the commit contains file: fileName.
6. public String getBlob(String fileName) : return the blob SHA - 1 of the file.
7. 



## Algorithms

## Persistence

