Write-Output "Preparing environment ..."

$_CWD = Get-Location
$_GH_ENV = [Environment]::GetEnvironmentVariable('GITHUB_ENV')
$_PATH = [Environment]::GetEnvironmentVariable('PATH')

if ($_PATH -eq $null -or $_PATH -eq "") {
    "PATH=$_CWD/hsdis" >> $_GH_ENV
} else {
    "PATH=$_PATH;$_CWD/hsdis" >> $_GH_ENV
}

Write-Output "Prepared environment"
