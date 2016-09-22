class openwis::middleware::jboss () {

    include openwis

    $jboss_home = "${openwis::openwis_home}/jboss-as-7.1.1.final"

    #==============================================================================
    # Download and install JBoss
    #==============================================================================
    file { '/tmp/download-and-unzip-jboss.sh':
        ensure => present,
        source => 'puppet:///modules/openwis/download-and-unzip-jboss.sh',
        mode => '0755'
    } ->
    exec { 'unpack-jboss':
        command => '/tmp/download-and-unzip-jboss.sh',
        creates => "${jboss_home}",
        timeout => 0
    }

    #==============================================================================
    # Deploy auxiliary files
    #==============================================================================
    file { "${openwis::openwis_home}/start_openwis_jboss.sh":
        ensure => present,
        source => '/tmp/openwis-dataservice-config/start_openwis_jboss.sh',
        owner => 'openwis',
        mode => '0755',
        require => Exec['unpack-jboss']
    }
    file { "${openwis::openwis_home}/stop_openwis_jboss.sh":
        ensure => present,
        source => '/tmp/openwis-dataservice-config/stop_openwis_jboss.sh',
        owner => 'openwis',
        mode => '0755',
        require => Exec['unpack-jboss']
    }
}