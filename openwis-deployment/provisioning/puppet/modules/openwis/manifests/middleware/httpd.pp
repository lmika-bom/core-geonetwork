class openwis::middleware::httpd ()
{
    include openwis

    #==============================================================================
    # Install Required packages
    #==============================================================================
    package { httpd:
      ensure => latest,
    }

    #==============================================================================
    # Enable & start services
    #==============================================================================
    service { httpd:
      ensure => running,
      enable => true,
      require => Package[httpd]
    }
}
