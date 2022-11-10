import org.gradle.api.Action
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.accessors.runtime.addDependencyTo
import com.vjh0107.projectextensions.internal.project

private val transitive = Action<ExternalModuleDependency> { isTransitive = false }

fun DependencyHandler.compileOnlyTransitively(dependencyNotation: String): ExternalModuleDependency {
    return addDependencyTo(this, "compileOnly", dependencyNotation, configurationAction = transitive)
}

fun DependencyHandler.compileOnlyModule(module: ModuleNotation): Dependency? {
    return add("compileOnly", project(module.path))
}

fun DependencyHandler.compileOnlyModuleAll(module: DependencySet<ModuleNotation>) {
    module.getDependencies().forEach { add("compileOnly", project(it.path)) }
}

fun DependencyHandler.implementationModule(module: ModuleNotation): Dependency? {
    return add("implementation", project(module.path))
}

fun DependencyHandler.apiModule(module: ModuleNotation): Dependency? {
    return add("api", project(module.path))
}

fun DependencyHandler.apiModuleAll(module: DependencySet<ModuleNotation>) {
    module.getDependencies().forEach { add("api", project(it.path)) }
}

fun DependencyHandler.testImplementationModule(module: ModuleNotation): Dependency? {
    return add("testImplementation", project(module.path))
}

fun DependencyHandler.implementationAll(dependencySet: DependencySet<String>) {
    dependencySet.getDependencies().forEach { add("implementation", it) }
}

fun DependencyHandler.apiAll(dependencySet: DependencySet<String>) {
    dependencySet.getDependencies().forEach { add("api", it) }
}

fun DependencyHandler.compileOnlyAll(dependencySet: DependencySet<String>, isTransitive: Boolean = false) {
    dependencySet.getDependencies().forEach { if (isTransitive) { compileOnlyTransitively(it) } else { add("compileOnly", it) } }
}

fun DependencyHandler.testImplementationAll(dependencySet: DependencySet<String>) {
    dependencySet.getDependencies().forEach { add("testImplementation", it) }
}