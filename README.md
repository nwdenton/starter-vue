# Workstation Setup
## Jenkins server compatible Node version
The latest node version available for Enterprise Linux 7 on our Jenkins build servers is v6.17.1
Matching this version on our dev machines should help us catch build issues earlier in our pipeline;
to do so follow these steps:
```$xslt
brew install node
npm install -g n
sudo n 6.17.1
```