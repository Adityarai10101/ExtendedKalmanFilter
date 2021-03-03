# FTC - ExtendedKalmanFilter
An EKF implementation for robotics

## GIT notes – command line

#### How to use .gitignore
1) Visit https://git-scm.com/docs/gitignore for pointers on how to add to the .gitignore file. Everything in this file will be ignored when committing new changes.

#### Local repo
1) ```git status``` shows the changes
2) ```git add <file>``` stages certain files for commit. ```git add .``` stages all changes for commit
3) ```git commit -m "insert comment here"``` creates a "snapshot of the code"
4) ```git log``` shows all "snapshots" under the current branch. To visit a snapshot, use ```git checkout <hashvalue>``` 
5) ```git branch``` lists all branches currently on your system. ```git branch <branch-name>``` creates a branch with the name specified. To switch to a branch, use ```git checkout <branch-name>```
6) ```git merge <branch-name>``` combines your current branch with the specified branch.

#### Getting the newest code
1) ```git pull``` will get the latest updates, of your current brnach, from github.
2) ```git fetch origin <branch>``` will create a local copy of a new branch from github

#### Uploading the newest code
1) ```git push -u origin <branch>``` will upload a new local branch to github
2) ```git push``` will be used to push subsequent snapshots

