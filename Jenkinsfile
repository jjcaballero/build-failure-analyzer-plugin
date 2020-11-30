@Library('build-plugin-test') _

//def labelNode = 'downtime-detection'

buildPlugin(
    platforms: ["linux"],
    jenkinsVersions: [null],
    findbugs: [run: true, archive: true],
    checkstyle: [archive: true, unstableTotalAll: 0],
    repo: ['https://github.com/guruvamsichintala/build-failure-analyzer-plugin.git']
  )
