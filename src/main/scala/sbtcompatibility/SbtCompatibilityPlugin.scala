package sbtcompatibility

import com.typesafe.tools.mima.plugin.MimaPlugin
import sbt._

object SbtCompatibilityPlugin extends AutoPlugin {

  override def trigger = allRequirements
  override def requires = MimaPlugin

  object autoImport extends SbtCompatibilityKeys {
    val Reconciliation = lmcoursier.definitions.Reconciliation
  }

  override def projectSettings =
    SbtCompatibilitySettings.updateSettings ++
      SbtCompatibilitySettings.reconciliationSettings ++
      SbtCompatibilitySettings.previousArtifactsSettings ++
      SbtCompatibilitySettings.findIssuesSettings
}