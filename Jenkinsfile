@Library('build-plugin-test') _

def labelNode = 'build-jenkins-plugins'

buildPlugin(
    platforms: [labelNode],
    jenkinsVersions: [null],
    findbugs: [run: true, archive: true],
    checkstyle: [archive: true, unstableTotalAll: 0],
    repo: ['https://github.com/guruvamsichintala/build-failure-analyzer-plugin.git']
  )
