package graphql.demo

data class Project(
    val slug: Long,
    val name: String,
    val repositoryUrl: String,
    val status: ProjectStatus
) {

}
