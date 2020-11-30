@Library('build-plugin-test') _

def labelNode = 'downtime-detection'

buildPlugin(
    platforms: [labelNode],
    jenkinsVersions: [null],
    findbugs: [run: true, archive: true],
    checkstyle: [archive: true, unstableTotalAll: 0]
  )
